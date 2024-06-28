package com.example.house_of_cuisines.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.house_of_cuisines.Activity.AddExpensesActivity
import com.example.house_of_cuisines.Model.DashboardBean
import com.example.house_of_cuisines.R
import com.example.house_of_cuisines.Utills.RvStatusClickListner
import com.stpl.antimatter.Utils.ApiContants


class HomeExpenseAdapter(
    var context: Activity,
    var list:List<DashboardBean.Data.Expense>,
    var rvClickListner: RvStatusClickListner
) : RecyclerView.Adapter<HomeExpenseAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder { // infalte the item Layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_expenses, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)
holder.ivView.visibility=View.GONE
holder.llVendorName.visibility=View.GONE
        /*     holder.tvAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
             holder.tvQtyAdd.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
             holder.tvQtyMinus.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(100f))
             holder.tvQty.background = RoundView(Color.TRANSPARENT, RoundView.getRadius(20f), true, R.color.orange)
             holder.tvOff.background = RoundView(context.resources.getColor(R.color.orange), RoundView.getRadius(20f))
             holder.tvAdd.visibility = View.VISIBLE*/

        holder.tvDate.text = list[position].createdAt
        holder.tvName.text = list[position].name
        holder.tvPaymentMode.text = list[position].paymentMode
        holder.tvCat.text = list[position].expenseCategory
        holder.tvSubCat.text = list[position].expenseSubcategory
      //  holder.tvVendorName.text = list[position].vendorName
        holder.tvExpenseType.text = list[position].expenseType
        holder.tvBuildType.text = list[position].build
        holder.tvNote.text = list[position].note
        holder.tvAmount.text = ApiContants.currency+list[position].amount

        holder.itemView.setOnClickListener {

            context.startActivity(
                Intent(
                    context,
                    AddExpensesActivity::class.java
                )
                    .putExtra("file", list[position].file)
                    .putExtra("id", list[position].id)
                    .putExtra("ids", list[position].ids)
                    .putExtra("vendorId", list[position].vendorId)
                    .putExtra("invoiceId", list[position].invoiceId)
                    .putExtra("build", list[position].build)
                    .putExtra("name", list[position].name)
                    .putExtra("note", list[position].note)
                    .putExtra("expenseCategory", list[position].expenseCategory)
                    .putExtra("expenseSubcategory", list[position].expenseSubcategory)
                    .putExtra("expenseDate", list[position].expenseDate)
                    .putExtra("amount", list[position].amount.toString())
                    .putExtra("customerName", list[position].customer.toString())
                    .putExtra("expenseType", list[position].expenseType.toString())
                    .putExtra("vendorName", "")
                    .putExtra("paymentMode", list[position].paymentMode?.toString())
                    .putExtra("refNo", list[position].refNo?.toString())
                    .putExtra("way","EditExpense")
            )
            //  rvClickListner.clickPos(list[position].indexId)
      /*      context.startActivity(
                Intent(
                    context,
                    AddExpensesActivity::class.java
                )
                    .putExtra("expenseResponse", list[position])
                    .putExtra("way","EditExpense")
            )*/
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvDate: TextView = itemview.findViewById(R.id.tvDate)
        val tvName: TextView = itemview.findViewById(R.id.tvName)
        val tvPaymentMode: TextView = itemview.findViewById(R.id.tvPaymentMode)
        val tvCat: TextView = itemview.findViewById(R.id.tvCat)
        val tvSubCat: TextView = itemview.findViewById(R.id.tvSubCat)
        val tvVendorName: TextView = itemview.findViewById(R.id.tvVendorName)
        val tvExpenseType: TextView = itemview.findViewById(R.id.tvExpenseType)
        val tvBuildType: TextView = itemview.findViewById(R.id.tvBuildType)
        val tvNote: TextView = itemview.findViewById(R.id.tvNote)
        val tvAmount: TextView = itemview.findViewById(R.id.tvAmount)
        val ivEdit: ImageView = itemview.findViewById(R.id.ivEdit)
        val ivView: ImageView = itemview.findViewById(R.id.ivView)
        val llVendorName: LinearLayout = itemview.findViewById(R.id.llVendorName)
    }

}