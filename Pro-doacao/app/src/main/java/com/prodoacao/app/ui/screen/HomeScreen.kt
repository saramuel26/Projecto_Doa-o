@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: DonationViewModel = viewModel()
) {
    var donations by remember { mutableStateOf(emptyList<Donation>()) }

    LaunchedEffect(Unit) {
        viewModel.loadDonations {
            donations = it
        }
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add")
            }) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(donations) { donation ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(donation.item, fontWeight = FontWeight.Bold)
                        Text("Categoria: ${donation.category}")
                        Text("Qtd: ${donation.quantity}")
                    }
                }
            }
        }
    }
}
