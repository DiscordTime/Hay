package br.com.hay.hay.feeling

class RegisterFeelingContract {

    interface View {
        fun setPresenter(presenter: Presenter)
        fun showSubTitle(subTitle: String)
        fun showFeelings(feelings: List<Feeling>)
    }

    interface Presenter {
        fun start()
        fun onClickNextButton()
    }

}
