package naclai.ballon.wellin.white.ui.fragments.item

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentChangeBinding

class ChangeFragment : Fragment(R.layout.fragment_change) {

    private val binding by viewBinding(FragmentChangeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}