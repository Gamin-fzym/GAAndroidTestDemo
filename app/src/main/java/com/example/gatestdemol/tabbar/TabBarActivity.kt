package com.example.gatestdemol.tabbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gatestdemol.R
import com.example.gatestdemol.databinding.ActivityTabBarBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "首页"
                1 -> "分类"
                2 -> "我的"
                else -> null
            }
            tab.icon = when(position) {
                0 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_home_selected)
                1 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_category_default)
                2 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_profile_default)
                else -> null
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // 一套Icon时用这种方式
                //tab?.icon?.setTint(ContextCompat.getColor(applicationContext, R.color.your_selected_text_color))
                // 两套Icon时用这种方式，XML中不要配置app:tabIconTint="@color/your_icon_tint_color"
                tab?.icon = when(tab?.position) {
                    0 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_home_selected)
                    1 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_category_selected)
                    2 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_profile_selected)
                    else -> null
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 一套Icon时用这种方式
                //tab?.icon?.setTint(ContextCompat.getColor(applicationContext, R.color.your_icon_tint_color))
                // 两套Icon时用这种方式，XML中不要配置app:tabIconTint="@color/your_icon_tint_color"
                tab?.icon = when(tab?.position) {
                    0 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_home_default)
                    1 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_category_default)
                    2 -> ContextCompat.getDrawable(this@TabBarActivity, R.drawable.ic_profile_default)
                    else -> null
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        })
    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> HomeFragment()
                1 -> CategoryFragment()
                2 -> ProfileFragment()
                else -> Fragment()
            }
        }
    }

}