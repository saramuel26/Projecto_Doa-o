import com.prodoacao.model.Users
import com.prodoacao.model.Donations
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq


object DatabaseFactory {
    fun init() {
        // Aqui cria as tabelas no banco se não existirem
        transaction {
            SchemaUtils.create(Users, Donations)
        }
    }
}
