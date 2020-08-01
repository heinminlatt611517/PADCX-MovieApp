package com.example.padcx_movieapp_assignment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.padcx_movieapp_assignment.data.vos.GenresVO
import com.example.padcx_movieapp_assignment.fragments.FragmentAction


class TabPagerAdapter(fm: FragmentManager,private val list : List<GenresVO>) : FragmentStatePagerAdapter(fm,list.count()) {
    override fun getItem(position: Int): Fragment {
       return FragmentAction.newInstance(list[position].id)
    }

    override fun getCount(): Int {
      return list.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position].name
    }

}