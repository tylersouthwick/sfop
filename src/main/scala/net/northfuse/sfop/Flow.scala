package net.northfuse.sfop

import scala.xml.Elem

trait Flow extends Function0[Elem] with ContentHolder[Block] {
	val flowName : String

	final def apply() = {
		<fo:flow flow-name={flowName}>
			{renderContents}
		</fo:flow>
	}
}
