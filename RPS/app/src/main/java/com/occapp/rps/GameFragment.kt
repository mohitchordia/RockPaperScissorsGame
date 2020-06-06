package com.occapp.rps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.occapp.rps.databinding.GameFragmentBinding


class GameFragment: Fragment() {


    private lateinit var binding: GameFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false)

        binding.rockButton.setOnClickListener { outputCompare(1) }
        binding.paperButton.setOnClickListener { outputCompare(2) }
        binding.scissorsButton.setOnClickListener { outputCompare(3) }


        return binding.root
    }

    private fun outputCompare(i: Int) {
        val j = (1..3).random()
        setCompImage(j)
        setPlayerImage(i)
        binding.viewinglayout.visibility = View.VISIBLE
            if( i==1 && j ==2 ){
                increaseCompScore()
                         }
        else if( i==2 && j ==3 ){
               increaseCompScore()
            }
        else if( i==3 && j ==1 ){
                increaseCompScore()
            }
        else if(i==j){
                //Toast.makeText(activity,"Its a draw",Toast.LENGTH_SHORT).show()
            }
        else{
                increasePlayerScore()
            }
    }

    private fun increasePlayerScore() {
        var str = binding.playerScore.text.toString()
        var num = str.toInt()
        num++
        binding.playerScore.setText(num.toString())
        //Toast.makeText(activity,"You win",Toast.LENGTH_SHORT).show()
    }
    private fun increaseCompScore() {
        var str = binding.computerScore.text.toString()
        var num = str.toInt()
        num++
        binding.computerScore.setText(num.toString())
        //Toast.makeText(activity,"Computer Wins",Toast.LENGTH_SHORT).show()
    }

    private fun setPlayerImage(i: Int) {
        val drawableResource = when (i) {

            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissors
        }
       binding.playerimageView.setImageResource(drawableResource)

    }
    private fun setCompImage(i: Int) {
        val drawableResource = when (i) {

            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissors
        }
        binding.compimageView.setImageResource(drawableResource)
    }
}
