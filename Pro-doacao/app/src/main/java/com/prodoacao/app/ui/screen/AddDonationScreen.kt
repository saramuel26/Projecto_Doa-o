@Composable
fun AddDonationScreen(
    navController: NavController,
    viewModel: DonationViewModel = viewModel()
) {
    var item by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Nova Doação", fontSize = 24.sp)

        OutlinedTextField(
            value = item,
            onValueChange = { item = it },
            label = { Text("Item") }
        )

        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Categoria") }
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantidade") }
        )

        Button(onClick = {
            viewModel.addDonation(
                Donation(
                    id = 0,
                    donor = "Anônimo",
                    item = item,
                    category = category,
                    quantity = quantity.toInt(),
                    description = ""
                )
            )
            navController.popBackStack()
        }) {
            Text("Salvar")
        }
    }
}
