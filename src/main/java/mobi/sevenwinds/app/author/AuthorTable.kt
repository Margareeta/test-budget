package mobi.sevenwinds.app.author

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable


object AuthorTable : IntIdTable(name = "author") {
    val name = varchar("fullname", 100)
    val dateOfCteation = date("date")
}

class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)

    var name by AuthorTable.name
    var dateOfCreation by AuthorTable.dateOfCteation

    fun toResponse(): AuthorRecord {
        return AuthorRecord(name, dateOfCreation)
    }
}

