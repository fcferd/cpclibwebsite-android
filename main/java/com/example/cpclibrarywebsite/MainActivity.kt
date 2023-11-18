package com.example.cpclibrarywebsite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.cpclibrarywebsite.R.id
import com.example.cpclibrarywebsite.R.id.tabs
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: NavigationView = findViewById(id.nav_view)
        navView.setNavigationItemSelectedListener {
            // Handle menu item clicks here
            // ...
            true
        }


        val viewPager: ViewPager = findViewById(id.viewPager)
        val tabs: TabLayout = findViewById(tabs)

        val adapter = YourPagerAdapter(supportFragmentManager)
            viewPager.adapter = adapter
            tabs.setupWithViewPager(viewPager)

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().isAutoInitEnabled = true

        drawerLayout = findViewById(id.drawer_layout)

        val toolbar = findViewById<Toolbar>(id.nav_toolbar)
        setSupportActionBar(toolbar)
        val navigationView = findViewById<NavigationView>(id.nav_view)

        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(id.nav_home)


        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(id.fragment_container, HomeFragment())
                    .commit()
            }
            id.nav_books -> {
                supportFragmentManager.beginTransaction()
                    .replace(id.fragment_container, BooksFragment())
                    .commit()
            }
            id.nav_libraryofficials -> {
                supportFragmentManager.beginTransaction()
                    .replace(id.fragment_container, LibraryOfficialsFragment())
                    .commit()
            }
            id.nav_about -> {
                supportFragmentManager.beginTransaction()
                    .replace(id.fragment_container, AboutFragment())
                    .commit()
            }
        }

        // Close the drawer after the transaction
        drawerLayout.closeDrawer(GravityCompat.START)

        // Indicate that the item selection event has been handled
        return true
    }


}





