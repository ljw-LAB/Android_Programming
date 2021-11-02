package com.acaroom.helloandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.ScrollingTabContainerView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.data_list_item.*

class ExtensionDataAdapter(
    //val items : ArrayList<String>
    val items : ArrayList<Pet>,
    val context : Context,
    val itemSelect : (Pet) -> Unit
) : RecyclerView.Adapter<ExtensionDataAdapter.ExtensionViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        //return ExtensionViewHolder(LayoutInflater.from(parent.context).inflate(
         val view = LayoutInflater.from(parent.context).inflate(
             R.layout.data_list_item,
             parent,
             false
         )
        return ExtensionViewHolder(view, itemSelect)
    }

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
//        holder.tv_data_type.text = items[position]
        holder.bind(items[position], context)
    }

    inner class ExtensionViewHolder(override val containerView: View, itemSelect : (Pet) -> Unit)
        :RecyclerView.ViewHolder(containerView), LayoutContainer{
            fun bind(pet : Pet, context: Context)
            {
                if(pet.photo != "")
                {
                    val resourceId = context.resources.getIdentifier(
                        pet.photo,
                        "drawable",
                        context.packageName
                    )
                    img_pet?.setImageResource(resourceId)
                }
                else
                {
                    img_pet?.setImageResource(R.mipmap.ic_launcher)
                }

                tv_breed.text = pet.breed
                tv_age.text = pet.age
                tv_gender.text = pet.gender

                itemView.setOnClickListener(){itemSelect(pet)}
            }
        }
}