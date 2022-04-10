package com.gato.foody.ui.fragment.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import com.gato.foody.R
import com.gato.foody.bindingadapters.RecipesRowBinding
import com.gato.foody.databinding.FragmentOverviewBinding
import com.gato.foody.models.Result
import com.gato.foody.util.Constants.Companion.RECIPE_RESULT_KEY


class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        val args = arguments
        val myBundle: Result = args?.getParcelable<Result>(RECIPE_RESULT_KEY) as Result

        binding.apply {
            mainImageView.load(myBundle.image)
            titleTextView.text = myBundle.title
            likesTextView.text = myBundle.aggregateLikes.toString()
            timeTextView.text = myBundle.readyInMinutes.toString()
        }
//        myBundle?.summary.let {
//            val summary = Jsoup.parse(it).text()
//            binding.summaryTextView.text = summary
//        }

        RecipesRowBinding.parseHtml(binding.summaryTextView, myBundle.summary)

        updateColor(myBundle.vegetarian , binding.vegetarianTextView, binding.vegetarianImageView)
        updateColor(myBundle.vegan , binding.veganTextView, binding.veganImageView)
        updateColor(myBundle.glutenFree , binding.glutenFreeTextView, binding.glutenFreeImageView)
        updateColor(myBundle.dairyFree , binding.dairyFreeTextView, binding.dairyFreeImageView)
        updateColor(myBundle.veryHealthy , binding.healthyTextView, binding.healthyImageView)
        updateColor(myBundle.cheap , binding.cheapTextView, binding.cheapImageView)


        return binding.root
    }

    private fun updateColor(stateIsOn: Boolean?, textView: TextView,imageView:ImageView){
        if(stateIsOn == true){
            imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
            textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}