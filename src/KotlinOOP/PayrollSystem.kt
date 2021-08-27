package KotlinOOP

open class Employee(
    protected val empId: Int,
    protected val empName: String,
    protected val bs: Float) {

    protected var hra: Float = 0f
    protected var da: Float = 0f

    protected var tax: Float = 0f
    protected var pf: Float = 0f

    protected var gs: Float = 0f
    protected var ns: Float = 0f

    open fun calSalary() {
        hra = bs * 0.35f
        da = bs * 0.45f

        when(bs) {
            in 70000f..95000f -> tax = bs * 0.1f
            in 40000f..69999f -> tax = bs * 0.05f
            else -> if(bs>95000f) tax = bs * 0.2f
        }

        pf = 0.12f * bs

        gs = bs + hra + da

        ns = gs - tax - pf
    }

    open fun printPaySlip() {
        println("Employee ID   : $empId")
        println("Employee Name : $empName")
        println("Basic Salary  : $bs")
        println("HRA           : $hra")
        println("DA            : $da")
        println("Tax           : $tax")
        println("PF            : $pf")
        println("Gross Salary = $bs + $hra + $da = $gs")
        println("Net Salary = $gs - $tax - $pf = $ns")
    }

}

fun main() {
    val emp = Worker(232, "Richard", 30000f, 10)
    val manager = Manager(100, "Garry", 50000f, 5)
    emp.calSalary()
    emp.printPaySlip()
    println("--------------------------------------------------------")
    manager.calSalary()
    manager.printPaySlip()

}

class Worker(
    empId: Int,
    empName: String,
    bs: Float,
    val otHours: Int): Employee(empId, empName, bs) {

    override fun calSalary() {
        super.calSalary()
        gs += otHours * 100
        ns += otHours * 100
    }

    override fun printPaySlip() {
        println("Employee ID   : $empId")
        println("Employee Name : $empName")
        println("Employee Desg : Worker")
        println("Basic Salary  : $bs")
        println("HRA           : $hra")
        println("DA            : $da")
        println("OT Hours      : $otHours")
        println("OT Hours Comp.: ${otHours*100}")
        println("Tax           : $tax")
        println("PF            : $pf")
        println("Gross Salary = $bs + $hra + $da + ${otHours*100} = $gs")
        println("Net Salary = $gs - $tax - $pf = $ns")
    }
}

class Manager(
    empId: Int,
    empName: String,
    bs: Float,
    val targers: Int) : Employee(empId, empName, bs) {

    override fun calSalary() {
        super.calSalary()
        gs += targers * 2000
        ns += targers * 2000
    }

    override fun printPaySlip() {
        println("Employee ID   : $empId")
        println("Employee Name : $empName")
        println("Employee Desg : Manager")
        println("Basic Salary  : $bs")
        println("HRA           : $hra")
        println("DA            : $da")
        println("Completed Targets : $targers")
        println("Bonus Comp.   : ${targers*2000}")
        println("Tax           : $tax")
        println("PF            : $pf")
        println("Gross Salary = $bs + $hra + $da + ${targers*2000} = $gs")
        println("Net Salary = $gs - $tax - $pf = $ns")
    }
}
