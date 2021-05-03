package com.diargegaj.horoscopeinfo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diargegaj.horoscopeinfo.R
import com.diargegaj.horoscopeinfo.ui.activity.SignsinfoActivity
import com.diargegaj.horoscopeinfo.ui.activity.SignsinfoActivity.Companion.SIGN_NAME
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_signs_title.view.*

/**
 * Created by Diar Gegaj on 21-05-02.
 */
class SignsTitleAdapter: RecyclerView.Adapter<SignsTitleAdapter.SignsTitleViewHolder>() {

    private var signs: List<String> = mutableListOf()

    fun setSigns(signs: List<String>){
        this.signs = signs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SignsTitleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_signs_title, parent, false)
        return SignsTitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SignsTitleViewHolder, position: Int) {
        holder.fillView(signs[position])
    }

    override fun getItemCount(): Int {
        return signs.size
    }

    inner class SignsTitleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun fillView(signName: String) {
            containerView.signTitle.text = signName

            containerView.signTitle.setOnClickListener {
                val intent = Intent(containerView.context, SignsinfoActivity::class.java)
                intent.putExtra(SIGN_NAME, signName)
                containerView.context.startActivity(intent)
            }
        }
    }
}