package com.example.tuan4_3

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    var recycler: RecyclerView? = null
    var adapter: MovieAdapter? = null
    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    var isGrid: Boolean = false
    var currentFragment: Fragment = NowPlaying()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        viewPager = findViewById(R.id.viewPager)

        val fragmentAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).setChecked(true)
            }

        })

        bottomNavigationView = findViewById(R.id.navBottom)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_nowPlaying -> {
                    viewPager.currentItem = 0
                    replaceFragment(NowPlaying())
                    currentFragment = NowPlaying()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.item_topRating -> {
                    viewPager.currentItem = 1
                    replaceFragment(TopRating())
                    currentFragment = TopRating()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    viewPager.currentItem = 2
                    replaceFragment(MyFavourite())
                    currentFragment = MyFavourite()
                    return@setOnNavigationItemSelectedListener true
                }
            }

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
