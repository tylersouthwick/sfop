package net.northfuse.sfop.examples

object Main {
	def main(args : Array[String]) {
		println("Hello world!")

		import java.io._
		val out = new FileOutputStream(new File("test.pdf"))
		HelloWorld.render(out)
		out.close()
	}
}
