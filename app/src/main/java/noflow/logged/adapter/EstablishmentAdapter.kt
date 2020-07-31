package noflow.logged.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.noflow.R
import kotlinx.android.synthetic.main.view_establishment_item.view.*


class EstablishmentAdapter(
    list: MutableList<EstablishmentItem>,
    private val selectCallback: (EstablishmentItem) -> Unit
) : RecyclerView.Adapter<EstablishmentViewHolder>() {

    private var data = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_establishment_item, parent, false)

        return EstablishmentViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: EstablishmentViewHolder, position: Int) {
        val view = holder.itemView
        val item = data[position]

        view.name.text = item.name
        view.address.text = item.address
        view.category.text = item.category
        view.state.isEnabled = item.open
        view.state.text = if (item.open) "aberto" else "fechado"

        if(item.allowArrow) {
            view.groupRow.visibility = View.VISIBLE
            // Fazer lógica pra pegar quantidade na fila
        }

        view.setOnClickListener {
            selectCallback(item)
        }
    }

    fun swap(datas: MutableList<EstablishmentItem>) {
        data.clear()
        data = datas
        notifyDataSetChanged()
    }
}

class EstablishmentViewHolder(view: View) : RecyclerView.ViewHolder(view)