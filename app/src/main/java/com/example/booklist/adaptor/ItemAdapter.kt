import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.booklist.BookDetailsActivity
import com.example.booklist.R

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Book>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val linearlayout: LinearLayout = view.findViewById(R.id.book_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    fun getLinearLayoutChilds(linearLayout: LinearLayout):MutableList<View>{
        var childViews= mutableListOf<View>()
        val childCount = linearLayout.childCount
        for (i in 0..childCount-1){
            childViews.add(linearLayout.getChildAt(i))
        }
        return childViews
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.linearlayout.setOnClickListener {
            val intent= Intent(it.context, BookDetailsActivity::class.java)
            intent.putExtra("NameStringResourceId",item.NameStringResourceId)
            intent.putExtra("WriterStringResourceId",item.WriterStringResourceId)
            intent.putExtra("yearStringResourceId",item.yearStringResourceId)
            intent.putExtra("editionStringResourceId",item.editionStringResourceId)
            intent.putExtra("summeryStringResourceId",item.summeryStringResourceId)
            intent.putExtra("imageResourceId",item.imageResourceId)
            println()
            it.context.startActivity(intent) }
        val childs=getLinearLayoutChilds(holder.linearlayout)
        val bookCover=childs[0] as AppCompatImageView
        val bookName=childs[1] as TextView
        val writer=childs[2] as TextView
        bookName.text="name: "+context.resources.getString(item.NameStringResourceId)
        writer.text="writer: "+context.resources.getString(item.WriterStringResourceId)
        bookCover.setImageDrawable(ResourcesCompat.getDrawable(context.resources,item.imageResourceId,null))
    }

    override fun getItemCount() = dataset.size
}
