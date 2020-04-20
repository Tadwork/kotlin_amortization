package debts

import io.kotlintest.specs.StringSpec
import io.kotlintest.shouldBe
import org.joda.time.LocalDate

class LoanTermTest : StringSpec() {

    init {
        "diff of one year"{
            val start = LocalDate.now()
            val end =  LocalDate.now().plusYears(1)
            val loanTerm = LoanTerm(start, end)
            with(loanTerm){
                years shouldBe 1
                months shouldBe 12
                days shouldBe 366
            }
        }

    }
}