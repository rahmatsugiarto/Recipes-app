package com.gato.foody.ui.fragment.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.gato.foody.databinding.FragmentInstructionBinding
import com.gato.foody.models.Result
import com.gato.foody.util.Constants.Companion.RECIPE_RESULT_KEY

class InstructionFragment : Fragment() {

    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentInstructionBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle = args?.getParcelable<Result>(RECIPE_RESULT_KEY)

        binding.instructionsWebView.webViewClient = WebViewClient()
        val websiteUrl: String = myBundle?.sourceUrl.toString()
        binding.instructionsWebView.loadUrl(websiteUrl)

        return binding.root
    }

    inner class WebViewClient : android.webkit.WebViewClient() {
        // Load the URL
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}