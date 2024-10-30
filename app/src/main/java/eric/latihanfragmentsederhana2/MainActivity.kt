package eric.latihanfragmentsederhana2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var defaultNumber:Int = 99;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mFragmentManager = supportFragmentManager
        val mfSatu = fSatu.newInstance(defaultNumber)
        val mfDua = fDua()
        val mfTiga = fTiga()

        mFragmentManager.findFragmentByTag(fSatu::class.java.simpleName)
        mFragmentManager.beginTransaction().add(R.id.frameLayout, mfSatu, fSatu::class.java.simpleName).commit()

        val _tvHalaman1 = findViewById<TextView>(R.id.tvHalaman1)
        val _tvHalaman2 = findViewById<TextView>(R.id.tvHalaman2)
        val _tvHalaman3 = findViewById<TextView>(R.id.tvHalaman3)

        _tvHalaman1.setOnClickListener {
            defaultNumber--
            val fragment = fSatu.newInstance(defaultNumber)
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, fragment, fSatu::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        _tvHalaman2.setOnClickListener {
            defaultNumber -= 2  // Kurangi defaultNumber sebesar 2
            val fragment = fDua.newInstance(defaultNumber)  // Kirim nilai terbaru ke fDua
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, fragment, fDua::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        _tvHalaman3.setOnClickListener {
            defaultNumber -= 3  // Kurangi defaultNumber sebesar 3
            val fragment = fTiga.newInstance(defaultNumber)  // Kirim nilai terbaru ke fTiga
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, fragment, fTiga::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }


    }


}