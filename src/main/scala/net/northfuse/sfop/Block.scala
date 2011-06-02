package net.northfuse.sfop

import scala.xml.Elem

object Block {
	def apply(s : String) = new Block {
		def apply() = <block>{s}</block>
	}
}

trait Block extends Function0[Elem] {
}

