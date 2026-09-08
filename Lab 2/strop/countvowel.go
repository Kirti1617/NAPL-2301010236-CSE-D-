package strop

func CountVowels(s string)int{
	count:=0
	for i:=0;i<len(s);i++{
		if s[i]=='a' || s[i]=='e' ||  s[i]=='i' || s[i]=='o' || s[i]=='u' || s[i]=='A'||
		 s[i]=='E' || s[i]=='I' || s[i]=='O' || s[i]=='U'{
			count++;
		 }
	}
	return count
}