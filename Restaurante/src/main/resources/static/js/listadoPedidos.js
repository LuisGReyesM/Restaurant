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
            const newRow =  await createTableRow(pedido);
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
});


