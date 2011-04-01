package org.northfuse.sfop

import org.apache.fop.apps._
import javax.xml.transform.stream.StreamSource
import javax.xml.transform._
import javax.xml.transform.sax._
import scala.xml.Elem
import java.io._
import org.apache.fop.apps.MimeConstants
import MimeConstants._

object FOP {
	val fopFactory = FopFactory.newInstance
	val transferFactory = TransformerFactory.newInstance
}

trait FOP {
	val foNamespace = "http://www.w3.org/1999/XSL/Format"

	/**
	 * Build an XML tree
	 *
	 * @return An Elem containing an FOP tree
	 */
	def buildXML: Elem

        //TODO find a more efficient way to convert an Elem to a Source
	implicit def toStreamSource(x: Elem): Source = new StreamSource(new StringReader(x.toString))

	import FOP._
	/**
	 * Generate a PDF to an output stream
	 * @param os OutputStream
	 */
	def generate(os: OutputStream) = {
		val fop = fopFactory.newFop(MIME_PDF, os)
		val transformer = transferFactory.newTransformer
		val result = new SAXResult(fop.getDefaultHandler())
		transformer.transform(buildXML, result)
		os.close
	}

}

