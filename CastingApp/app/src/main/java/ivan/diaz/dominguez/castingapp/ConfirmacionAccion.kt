package ivan.diaz.dominguez.castingapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import ivan.diaz.dominguez.castingapp.databinding.ConfirmacionAccionFragmentBinding
import ivan.diaz.dominguez.castingapp.databinding.SeleccionCandidatosFragmentBinding
import ivan.diaz.dominguez.castingapp.databinding.SeleccionRodajeFragmentBinding

class ConfirmacionAccion : Fragment() {

    companion object {
        fun newInstance() = ConfirmacionAccion()
    }
    private var _binding: ConfirmacionAccionFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: ConfirmacionAccionViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Confirme su accion"
        _binding = ConfirmacionAccionFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConfirmacionAccionViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al segundo fragmento.
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_confirmacionAccion_to_seleccionRodajeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}