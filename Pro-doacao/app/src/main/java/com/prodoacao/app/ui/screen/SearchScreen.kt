@Composable
fun SearchScreen(viewModel: DonationViewModel = viewModel()) {
    var query by remember { mutableStateOf("") }
    var donations by remember { mutableStateOf(emptyList<Donation>()) }

    LaunchedEffect(Unit) {
        viewModel.loadDonations {
            donations = it
        }
    }

    val filtered = donations.filter {
        it.item.contains(query, true) ||
                it.category.contains(query, true)
    }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Buscar") }
        )

        LazyColumn {
            items(filtered) {
                Text(it.item)
            }
        }
    }
}
