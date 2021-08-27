package com.msp.restapi

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.msp.restapi.restgo.RGUserList

class RVAdapter(val list: List<RGUserList.Data>) : RecyclerView.Adapter<RVAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val tv = TextView(parent.context)
        return VH(tv)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val rgUser = list[position]
        (holder.itemView as TextView).text =
            "id:             ${rgUser.id}\n" +
                    "name:      ${rgUser.name}\n" +
                    "email:     ${rgUser.email},\n" +
                    "gender:    ${rgUser.gender}\n" +
                    "status:    ${rgUser.status}\n"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}