package debts

data class InterestRate(
    val rate:Double,
    val rateType:InterestRateType = InterestRateType.APR) {

}

enum class InterestRateType {
    APR,
    Factor
}
