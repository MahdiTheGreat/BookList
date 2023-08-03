import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Book(
    @StringRes val NameStringResourceId: Int,
    @StringRes val WriterStringResourceId: Int,
    @StringRes val editionStringResourceId: Int,
    @StringRes val summeryStringResourceId: Int,
    @StringRes val yearStringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)