package naclai.ballon.wellin.white.ui.fragments.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import naclai.ballon.wellin.R
import naclai.ballon.wellin.databinding.FragmentOnBoardBinding

class OnBoardFragment : Fragment(R.layout.fragment_on_board) {

    private val binding by viewBinding(FragmentOnBoardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}