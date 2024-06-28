package com.example.house_of_cuisines.Adapter

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.house_of_cuisines.Activity.AddExpensesActivity
import com.example.house_of_cuisines.Model.GetExpensesBean
import com.example.house_of_cuisines.R
import com.example.house_of_cuisines.Utills.GeneralUtilities
import com.example.house_of_cuisines.Utills.RvStatusClickListner
import com.stpl.antimatter.Utils.ApiContants


class GetExpenseAdapter(
    var context: Activity,
    var list: List<GetExpensesBean.Data>,
    var rvClickListner: RvStatusClickListner
) : RecyclerView.Adapter<GetExpenseAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder { // infalte the item Layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_expenses, parent, false)
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

        holder.tvDate.text = list[position].createdAt
        holder.tvName.text = list[position].name
        holder.tvPaymentMode.text = list[position].paymentMode
        holder.tvCat.text = list[position].expenseCategory
        holder.tvSubCat.text = list[position].expenseSubcategory
        holder.tvVendorName.text = list[position].vendorName
        holder.tvExpenseType.text = list[position].expenseType
        holder.tvBuildType.text = list[position].build
        holder.tvNote.text = list[position].note
        holder.tvAmount.text = ApiContants.currency + list[position].amount
        holder.ivEdit.setOnClickListener {

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
                    .putExtra("customerName", list[position].customerName.toString())
                    .putExtra("expenseType", list[position].expenseType.toString())
                    .putExtra("vendorName", list[position].vendorName?.toString())
                    .putExtra("refNo", list[position].refNo?.toString())
                    .putExtra("paymentMode", list[position].paymentMode?.toString())
                    .putExtra("way","EditExpense")
            )
        }
        holder.itemView.setOnClickListener {
            //  rvClickListner.clickPos(list[position].indexId)
        }
        holder.ivView.setOnClickListener {
            openExpesneDialog(list[position].file)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
   /*  context.startActivity(
                Intent(
                    context,
                    AddExpensesActivity::class.java
                )
                    .putExtra("expenseResponse", list[position])
                    .putExtra("way","EditExpense")
            )*/
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
    }
    fun openExpesneDialog(file: String) {
        val dialog: Dialog = GeneralUtilities.openBootmSheetDailog(
            R.layout.dialog_view_expense, R.style.AppBottomSheetDialogTheme,
            context
        )
        val ivClose = dialog.findViewById<ImageView>(R.id.ivClose)
        val ivExpesneImg = dialog.findViewById<ImageView>(R.id.ivExpesneImg) as ImageView

        Glide.with(context).load(ApiContants.BaseUrl+file).into(ivExpesneImg)
        ivClose.setOnClickListener { dialog.dismiss() }
    }
}