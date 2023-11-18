@file:Suppress("DEPRECATION")

package com.example.cpclibrarywebsite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class YourPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // Return the fragment for the corresponding tab position
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                BooksFragment()
            }
            2 -> {
                LibraryOfficialsFragment()
            }
            3 -> {
                AboutFragment()
            }
            else -> {
                HomeFragment()
            } // Default to HomeFragment
        }
    }

    override fun getCount(): Int {
        // Return the total number of tabs
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Return the title for each tab
        return when (position) {
            0 -> "Home"
            1 -> "Books"
            2 -> "Library Officials"
            3 -> "About"
            else -> null
        }
    }
}