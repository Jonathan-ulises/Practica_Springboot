// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});


const cargarUsuarios = async () => {

    const request = await fetch('api/usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const usuarios = await request.json();

    let usuario = '';
    for(let usu of usuarios) {
        usuario += `
        <tr>
            <td>${usu.id}</td>
            <td>${usu.nombre} ${usu.apellido}</td>
            <td>${usu.email}</td>
            <td>${usu.telefono == null ? '--' : usu.telefono}</td>
            <td>
                <a href="#" class="btn btn-danger btn-circle" onclick="eliminarUsuario(${usu.id})">
                    <i class="fas fa-trash"></i>
                </a>
            </td>
        </tr>`
    }
    document.querySelector('#usuarios tbody').outerHTML = usuario;
}

const eliminarUsuario = async (id) => {
    if (!confirm("¿Desea eliminar este usuario?")) {
        return;
    }

    const request = await fetch(`api/usuarios/${id}`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload();
}