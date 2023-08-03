import com.example.booklist.R

class Datasource() {
    fun loadBooks(): List<Book> {
        return listOf<Book>(
            Book(
                R.string.book1,
                R.string.book1Writer,
                R.string.book1Edition,
                R.string.book1Summery,
                R.string.book1Year,
                R.drawable.book1cover),
            Book(
                R.string.book2,
                R.string.book2Writer,
                R.string.book2Edition,
                R.string.book2Summery,
                R.string.book2Year,
                R.drawable.book2cover),
            Book(
                R.string.book3,
                R.string.book3Writer,
                R.string.book3Edition,
                R.string.book3Summery,
                R.string.book3Year,
                R.drawable.book3cover),
            Book(
                R.string.book4,
                R.string.book4Writer,
                R.string.book4Edition,
                R.string.book4Summery,
                R.string.book4Year,
                R.drawable.book4cover),
            Book(
                R.string.book5,
                R.string.book5Writer,
                R.string.book5Edition,
                R.string.book5Summery,
                R.string.book5Year,
                R.drawable.book5cover))

    }
}
