%#(set-global-staff-size 10)

\header{
	tagline = "" 
	title = "Interval Music"
	subtitle="#
1502320050
"
}

\paper{
  indent = 2\cm
  left-margin = 1.5\cm
  right-margin = 1.5\cm
  top-margin = 2\cm
  bottom-margin = 1.5\cm
  ragged-last-bottom = ##t
  print-all-headers = ##t
  print-page-number = ##f
}

\score{
\header{
	tagline = "" 
	title = "  "
	subtitle="  "
}
 \new  StaffGroup  <<

\new Staff \with {
    instrumentName = #"
1
"
	midiInstrument = "Voice Oohs"
  }
\absolute {
\numericTimeSignature

\clef
"treble"

a'4 e'4 dis'4 

	\bar "|."

}



\new Staff \with {
    instrumentName = #"
2
"
	midiInstrument = "Voice Oohs"
  }
\absolute {
\numericTimeSignature

\clef
"treble"

g'4 dis'4 e'4 

	\bar "|."

}


>>
\layout{}
\midi{}
}

