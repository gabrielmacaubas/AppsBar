package com.example.apps_bar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apps_bar.ui.theme.Apps_barTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Apps_barTheme {
                val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = { LargeTopAppBarExample(scrollBehavior = scrollBehavior) },
                    bottomBar = { BottomAppBarExample() }
                ) { innerPadding ->
                    ScrollContent(innerPadding)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarExample(scrollBehavior: TopAppBarScrollBehavior) {
    LargeTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFD32F2F),
            titleContentColor = Color.White,
        ),
        title = {
            Text(
                "Bolo de Rolo",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@Composable
fun BottomAppBarExample() {
    BottomAppBar(
        containerColor = Color(0xFFD32F2F),
        contentColor = Color.White,
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Check, contentDescription = "Confirmar")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Edit, contentDescription = "Editar")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Call, contentDescription = "Gravar")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.AccountBox, contentDescription = "Imagem")
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar")
            }
        }
    )
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val ingredientes = listOf(
        "250g de manteiga",
        "250g de açúcar",
        "5 ovos",
        "250g de farinha de trigo",
        "1 colher de chá de essência de baunilha",
        "300g de goiabada",
        "1/2 xícara de água",
        "Açúcar de confeiteiro para polvilhar"
    )

    val instrucoes = listOf(
        "Bata a manteiga com o açúcar até formar um creme claro.",
        "Adicione os ovos um a um, batendo bem após cada adição.",
        "Acrescente a farinha de trigo peneirada e misture até ficar homogêneo.",
        "Adicione a essência de baunilha e misture.",
        "Espalhe pequenas porções da massa em assadeiras forradas com papel manteiga e asse por cerca de 5 minutos a 180ºC.",
        "Derreta a goiabada com a água em fogo baixo até formar um creme.",
        "Monte o bolo em camadas, alternando massa e goiabada.",
        "Enrole como um rocambole e polvilhe com açúcar de confeiteiro."
    )

    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        item { Text("Ingredientes", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(16.dp)) }
        items(ingredientes) { ingrediente ->
            Text("• $ingrediente", modifier = Modifier.padding(start = 16.dp, bottom = 8.dp))
        }
        item { Text("Modo de Preparo", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(16.dp)) }
        items(instrucoes) { instrucao ->
            Text("- $instrucao", modifier = Modifier.padding(start = 16.dp, bottom = 8.dp))
        }
    }
}
