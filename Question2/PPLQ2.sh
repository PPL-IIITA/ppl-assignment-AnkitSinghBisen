file="log.txt"
if [ -f $file ] ; then
		rm $file
fi
javac PPLQ2.java
java PPLQ2