package com.example.pantallaprincipal.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pantallaprincipal.component.Contact

class Contacto(val nombre: String, val telefono: String)

@Composable
fun ListItemsExample() {
    // Estados para los campos de texto
    var nameInput by remember { mutableStateOf("") }
    var phoneInput by remember { mutableStateOf("") }

    // lista que se actualiza
    val contacts = remember {
        mutableStateListOf(
            Contacto("Jesus", "12345678"),
            Contacto("Wanda", "98765432")
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // FORMULARIO
        Text(text = "Agregar Nuevo Contacto", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = phoneInput,
            onValueChange = { phoneInput = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (nameInput.isNotBlank() && phoneInput.isNotBlank()) {
                    contacts.add(Contacto(nameInput, phoneInput))
                    nameInput = ""
                    phoneInput = ""
                }
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {
            Text("Añadir a la lista")
        }

        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(16.dp))

        // LISTA
        LazyColumn {
            items(contacts) { contact ->
                Contact(name = contact.nombre, phone = contact.telefono)
                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp), thickness = 0.5.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemsExamplePreview() {
    ListItemsExample()
}