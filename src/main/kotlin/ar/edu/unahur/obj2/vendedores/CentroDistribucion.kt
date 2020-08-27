package ar.edu.unahur.obj2.vendedores

class CentroDistribucion(val ciudad: Ciudad)
{
    val vendedores = mutableListOf<Vendedor>()

    fun agregaVendedor(vendedor: Vendedor)
    {
        if(! vendedores.contains(vendedor))
        {
            vendedores.add(vendedor)
        }
        else
        {
            throw Exception("Vendedor registrado")
        }
    }

    fun elVendedorEstrella() = vendedores.maxBy {it.puntajeCertificaciones()}

    fun puedeCubrir(ciudad: Ciudad) = vendedores.any {it.puedeTrabajarEn(ciudad)}

    fun vendedoresGenericos(): List<Vendedor>
    {
        return vendedores.filter {it.otrasCertificaciones() > 1}
    }

    fun esRobusto(): Boolean
    {
        return this.cantRobustos() > 3
    }

    fun cantRobustos(): Int
    {
        return vendedores.count {it.esFirme()}
    }

    fun repartirCertificaciones(certificacion: Certificacion)
    {
        vendedores.forEach {it.agregarCertificacion(certificacion)}
    }
}