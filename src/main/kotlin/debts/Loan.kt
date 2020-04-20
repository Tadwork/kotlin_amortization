package debts
import debts.LoanPaymentFrequency.*;
sealed class Loan( val principal:Double, val interestRate:InterestRate, val loanTerm:LoanTerm, val paymentFrequency: LoanPaymentFrequency){
    abstract val interest:Double
    val paymentsInTerm by lazy {
        when(paymentFrequency){
            Daily -> loanTerm.days
            Monthly -> loanTerm.months
            Annually -> loanTerm.years
            Once -> 1
        }
    }
    abstract fun periodicInterestPayment(paymentNumber:Int): Double
}


class SimpleLoan(
    principal: Double,
    interestRate: InterestRate,
    loanTerm: LoanTerm,
    paymentFrequency: LoanPaymentFrequency
) : Loan(principal, interestRate, loanTerm, paymentFrequency) {
    override val interest = interestRate.rate * principal
    override fun periodicInterestPayment(paymentNumber:Int): Double =if(paymentsInTerm > 0) interest * ( 1.0 / paymentsInTerm.toDouble() ) else 0.0
}
class CompoundLoan(
    principal: Double,
    interestRate: InterestRate,
    loanTerm: LoanTerm,
    paymentFrequency: LoanPaymentFrequency
) : Loan(principal, interestRate, loanTerm, paymentFrequency) {
    override val interest = interestRate.rate * principal
    override fun periodicInterestPayment(paymentNumber:Int): Double = if(interest > 0.0) interest * ( 1.0 / paymentsInTerm.toDouble() ) else 0.0
}