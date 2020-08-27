package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)
  val laPampa = Provincia(353106)
  val santaRosa = Ciudad(laPampa)
  val santaCruz = Provincia(320469)
  val calafate = Ciudad(santaCruz)
  val buenosAires = Provincia(16660000)
  val avellaneda = Ciudad(buenosAires)
  val moron = Ciudad(buenosAires)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    val fijo1 = VendedorFijo(santaRosa)
    val fijo2 = VendedorFijo(avellaneda)
    val fijo3 = VendedorFijo(moron)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
        fijo1.puedeTrabajarEn(santaRosa).shouldBeTrue()
        fijo2.puedeTrabajarEn(avellaneda).shouldBeTrue()
        fijo3.puedeTrabajarEn(moron).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
        fijo1.puedeTrabajarEn(moron).shouldBeFalse()
        fijo2.puedeTrabajarEn(santaRosa).shouldBeFalse()
        fijo3.puedeTrabajarEn(avellaneda).shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))
    val viajante2 = Viajante(listOf(laPampa))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante2.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }
  }
})


