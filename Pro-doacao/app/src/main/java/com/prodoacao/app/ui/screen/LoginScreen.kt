@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", fontSize = 26.sp)

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate("home")
            }
        ) {
            Text("Entrar")
        }

        TextButton(onClick = {
            navController.navigate("register")
        }) {
            Text("Criar conta")
        }
    }
}
