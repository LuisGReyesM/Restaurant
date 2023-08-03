//Función que formatea la fecha
function formatDate(dateString) {
  const date = new Date(dateString);
  const day = String(date.getDate()).padStart(2, '0');
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const year = date.getFullYear();
  return `${year}-${month}-${day}`;
}

// Función para crear una fila de la tabla
async function createTableRow(pedido) {
  const nombreCamarero = await obtenerNombreCamareroPorID(pedido.camareroId);
  const newRow = document.createElement('tr');
  newRow.innerHTML = `
    <td>${pedido.mesaId}</td>
    <td>${nombreCamarero}</td>
    <td>${formatDate(pedido.fecha)}</td>
    <td>${pedido.total}</td>
    <td>
      <a href="#" class="fas fa-eye btn-ver-detalles"></a>
      </td>`;
  return newRow;
}

// Función para obtener el nombre del camarero por su ID
async function obtenerNombreCamareroPorID(id) {
  try {
    const response = await fetch('http://localhost:8080/api/camarero');
    if (!response.ok) {
      throw new Error('La solicitud ha fallado.');
    }
    const camareros = await response.json();
    const clienteEncontrado = camareros.find(camarero => camarero.id === id);
    return clienteEncontrado ? clienteEncontrado.nombre : 'Cliente no encontrado';
  } catch (error) {
    console.error('Error al obtener los datos de clientes:', error);
    return null;
  }
}

//Función para cargar los datos de pago en la tabla
function cargarPedidos() {
  const tableBody = document.querySelector('#pedidosTable tbody');
  fetch('http://localhost:8080/api/pedido')
    .then(response => {
      if (!response.ok) {
        throw new Error('La solicitud ha fallado.');
      }
      return response.json();
    })
    .then(async data => {
      for (const pedido of data) {
        const newRow = await createTableRow(pedido);
        tableBody.appendChild(newRow);
      }
    })
    .catch(error => {
      console.error('Ha ocurrido un error:', error);
    });
}

async function cargarCombobox() {
  const fechaSelect = document.getElementById('fecha');
  const camareroSelect = document.getElementById('camarero');
  const mesaSelect = document.getElementById('mesa');

  try {
    const response = await fetch('http://localhost:8080/api/pedido');
    if (!response.ok) {
      throw new Error('La solicitud ha fallado.');
    }
    const data = await response.json();

    const fechas = new Set();
    const camareros = new Set();
    const mesas = new Set();

    for (const pedido of data) {
      fechas.add(formatDate(pedido.fecha));
      const nombreCamarero = await obtenerNombreCamareroPorID(pedido.camareroId);
      camareros.add(nombreCamarero);
      mesas.add(pedido.mesaId);
    }

    for (const fecha of fechas) {
      const option = document.createElement('option');
      option.textContent = fecha;
      fechaSelect.appendChild(option);
    }

    for (const camarero of camareros) {
      const option = document.createElement('option');
      option.textContent = camarero;
      camareroSelect.appendChild(option);
    }

    for (const mesa of mesas) {
      const option = document.createElement('option');
      option.textContent = mesa;
      mesaSelect.appendChild(option);
    }
  } catch (error) {
    console.error('Ha ocurrido un error:', error);
  }
}

// Cargar los datos al cargar la página
document.addEventListener("DOMContentLoaded", async () => {
  await cargarCombobox();
  cargarPedidos();

  // Obtener referencias a los elementos de los combobox
  const fechaSelect = document.getElementById('fecha');
  const camareroSelect = document.getElementById('camarero');
  const mesaSelect = document.getElementById('mesa');

  // Obtener referencias a los botones de opción
  const opcionFecha = document.getElementById('opcionFecha');
  const opcionCamarero = document.getElementById('opcionCamarero');
  const opcionMesa = document.getElementById('opcionMesa');

  // Agregar un evento para habilitar/deshabilitar los combobox según el botón de opción seleccionado
  opcionFecha.addEventListener('change', () => {
    fechaSelect.disabled = !opcionFecha.checked;
    camareroSelect.disabled = true;
    mesaSelect.disabled = true;
  });

  opcionCamarero.addEventListener('change', () => {
    fechaSelect.disabled = true;
    camareroSelect.disabled = !opcionCamarero.checked;
    mesaSelect.disabled = true;
  });

  opcionMesa.addEventListener('change', () => {
    fechaSelect.disabled = true;
    camareroSelect.disabled = true;
    mesaSelect.disabled = !opcionMesa.checked;
  });

  // Agregar el event listener para el botón "Buscar"
  const btnBuscar = document.getElementById('btnBuscar');
  btnBuscar.addEventListener('click', buscarPedidos);
});

// Función para filtrar los pedidos según los valores seleccionados en los combobox
function filtrarPedidos(pedidos, fecha, camareroId, mesa) {
  return pedidos.filter(pedido => {
    let fechaMatch = true;
    let camareroMatch = true;
    let mesaMatch = true;

    if (fecha) {
      fechaMatch = formatDate(pedido.fecha) === fecha;
    }

    if (camareroId) {
      camareroMatch = pedido.camareroId === camareroId;
    }

    if (mesa) {
      mesaMatch = pedido.mesaId === mesa;
    }

    return fechaMatch && camareroMatch && mesaMatch;
  });
}

// Función para realizar la búsqueda de pedidos según los valores seleccionados en los combobox
async function buscarPedidos() {
  const fechaSelect = document.getElementById('fecha');
  const camareroSelect = document.getElementById('camarero');
  const mesaSelect = document.getElementById('mesa');

  const fechaSeleccionada = fechaSelect.disabled ? null : fechaSelect.value;
  const camareroSeleccionado = camareroSelect.disabled ? null : camareroSelect.value;
  const mesaSeleccionada = mesaSelect.disabled ? null : parseInt(mesaSelect.value, 10);

  try {
    const response = await fetch('http://localhost:8080/api/pedido');
    if (!response.ok) {
      throw new Error('La solicitud ha fallado.');
    }
    const data = await response.json();

    // Verificar si el camarero seleccionado se encuentra en la lista de camareros
    const camareroId = camareroSeleccionado ? await obtenerIdCamareroPorNombre(camareroSeleccionado) : null;

    // Filtrar los pedidos según los valores seleccionados en los combobox
    const pedidosFiltrados = filtrarPedidos(data, fechaSeleccionada, camareroId, mesaSeleccionada);

    // Actualizar la tabla con los resultados filtrados
    const tableBody = document.querySelector('#pedidosTable tbody');
    tableBody.innerHTML = ''; // Borra el contenido actual de la tabla

    for (const pedido of pedidosFiltrados) {
      const newRow = await createTableRow(pedido);
      tableBody.appendChild(newRow);
    }
  } catch (error) {
    console.error('Ha ocurrido un error:', error);
  }
}

// Función para obtener el ID del camarero por su nombre
async function obtenerIdCamareroPorNombre(nombre) {
  try {
    const response = await fetch('http://localhost:8080/api/camarero');
    if (!response.ok) {
      throw new Error('La solicitud ha fallado.');
    }
    const camareros = await response.json();
    const camareroEncontrado = camareros.find(camarero => camarero.nombre === nombre);

    return camareroEncontrado ? camareroEncontrado.id : null;
  } catch (error) {
    console.error('Error al obtener los datos de camareros:', error);
    return null;
  }
}
