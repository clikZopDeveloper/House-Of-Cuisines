package com.example.house_of_cuisines.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.house_of_cuisines.Model.WalletLedgerBean
import com.example.house_of_cuisines.R
import com.example.house_of_cuisines.Utills.RvStatusClickListner
import com.stpl.antimatter.Utils.ApiContants


class ExpenseAdapter(var context: Activity, var list: List<WalletLedgerBean.Data.Expense>, var rvClickListner: RvStatusClickListner) : RecyclerView.Adapter<ExpenseAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // infalte the item Layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_expene, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)

   /*     holder.tvAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvQtyAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQtyMinus.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
        holder.tvQty.background = RoundView(Color.TRANSPARENT, RoundView.getRadius(20f), true, R.color.orange)
        holder.tvOff.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
        holder.tvAdd.visibility = View.VISIBLE*/

        holder.tvAmount.text= ApiContants.currency+list[position].amount
        holder.tvExpense.text= list[position].expenseType
        holder.tvName.text= list[position].name
        holder.tvCategory.text= list[position].expenseCategory
        holder.tvSubCategory.text= list[position].expenseSubcategory
        holder.tvNote.text= list[position].note
        holder.tvDate.text= list[position].createdAt

        holder.itemView.setOnClickListener {
         //  rvClickListner.clickPos(list[position].indexId)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvAmount: TextView = itemview.findViewById(R.id.tvAmount)
       val tvExpense: TextView = itemview.findViewById(R.id.tvExpense)
       val tvName: TextView = itemview.findViewById(R.id.tvName)
       val tvCategory: TextView = itemview.findViewById(R.id.tvCategory)
       val tvSubCategory: TextView = itemview.findViewById(R.id.tvSubCategory)
       val tvNote: TextView = itemview.findViewById(R.id.tvNote)
       val tvDate: TextView = itemview.findViewById(R.id.tvDate)
    }

}