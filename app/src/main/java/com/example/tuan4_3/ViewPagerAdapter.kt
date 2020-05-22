package com.example.tuan4_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tuan4_3.MyFavourite
import com.example.tuan4_3.NowPlaying
import com.example.tuan4_3.TopRating

class ViewPagerAdapter (fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
         return when (position){
             0->{
                 NowPlaying()
             }
             1->{
                 TopRating()
             }
             else->{
                 return Favorite()
             }
        }
    }

    override fun getCount(): Int {
        return  3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Now Playing"
            1->"Top Rating"
            else ->{
                return "My Favorite"
            }
        }
    }
}