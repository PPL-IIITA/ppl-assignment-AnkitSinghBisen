file="log.txt"
if [ -f $file ] ; then
		rm $file
fi
javac PPLQ1.java
java PPLQ1