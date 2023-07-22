package naclai.ballon.wellin.white.ui.fragments.item

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentAddBinding

class AddFragment : Fragment(R.layout.fragment_add) {

    private val binding by viewBinding(FragmentAddBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}