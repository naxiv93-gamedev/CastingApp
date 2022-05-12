package ivan.diaz.dominguez.castingapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ivan.diaz.dominguez.castingapp.databinding.SeleccionCandidatosFragmentBinding
import ivan.diaz.dominguez.castingapp.ui.ActorListAdapter
import kotlinx.android.synthetic.main.seleccion_candidatos_fragment.*

class SeleccionCandidatos : Fragment() {

    companion object {
        fun newInstance() = SeleccionCandidatos()
    }
    private var _binding: SeleccionCandidatosFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SeleccionCandidatosViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)?.supportActionBar?.title = "Seleccione candidatos"
        _binding = SeleccionCandidatosFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SeleccionCandidatosViewModel::class.java)
        initUI()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Al pulsar el botón, navegamos al segundo fragmento.
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_seleccionCandidatos_to_confirmacionAccion)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun initUI(){
        binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.pokelistRecyclerView.adapter = ActorListAdapter()

        viewModel.getActors()

        viewModel.pokemonList.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as ActorListAdapter).setData(list)
        })
    }
}
