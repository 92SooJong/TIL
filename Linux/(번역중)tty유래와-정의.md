Linux나 UNIX를 사용하다 보면 "TTY"라는 용어를 많이 듣게 되는데 "TTY"는 무엇일까?

Do note that there’s no definitive answer to this, but it relates to how input/output devices interacted in the past.
So, you will have to know a bit of history to get a clear picture.


# 역사속의 TTY
tty는 1830년대의 Teleprinter로부터 시작한다.
Teleprinter는 wire로 연결된 기기로 메세지를 보내고, 결과를 받을수 있도록 해줬다.
Teleprinter의 입력장치는 지금의 키보드 모습을 하고 있었기때문에 당시 사용하던 모스코드를 대체하기에 충분했다. ( 1901년 도널드 머레이에 의해 현대적인 모습의 키보드로 다시 탈바꿈한다.)
Teleprinter는 한명의 오퍼레이터가 필요했다.

Murray 코드는 오퍼레이터가 메세지를 손쉽게 보낼수 있도록 해줬다. 덕분에 Teleprinter가 1908년 상업화된 Teletypewriter로 전화하게 된다.
TTY는 이 Teletypewriter의 약자이다.


The difference between the Teletypewriter and a regular typewriter was that a Teletypewriter was attached to a communication device to send the typed message.

Teletypewriter made it possible for humans to communicate faster over a wire without any computers until now.

And, this is where “TTY” came into existence.

The (relatively) Modern Concept
Now, you must be wondering, how did it land into modern computing and in Linux?

Well, for starters, when Teletypewriter hit the market, some years later semiconductor transistors were developed which then evolved into microprocessors making a computer possible.

Initial computers didn’t have the concept of a keyboard. Punch cards were the input method.

punch card program
A punch card computer program which was inserted into computers instead of typing it via keyboard (TTY) | Image credit

While computers were evolving, batch input cards were eventually replaced by Teletypewriters as a convenient input/output device.

lgp 30 early computer 1956
LGP-30 computer in 1956 with a TTY attached to it
With technological advancements, the Teletypewriters were ‘virtualized’ using electronics. So, you wouldn’t need a physical, mechanical TTY, but a virtual, electronic TTY.

Earlier computers didn’t even have video screens. Things were printed on paper instead of displaying on a screen (which didn’t exist). And hence you see the use of the term ‘print’, not ‘display’. Videos were added to terminals later as technology advanced.

In other words, you might have heard of them as video terminals. Or, you could call them “physical” terminals.

And, then these evolved into software emulated terminals which came with enhanced abilities and features.

This is what you call a “terminal emulator”. For instance, GNOME Terminal, or Konsole, are some of the best terminal emulators that you will find for Linux.

So, What is TTY in Linux?
When it comes to Linux, TTY is an abstract device in UNIX and Linux. Sometimes it refers to a physical input device such as a serial port, and sometimes it refers to a virtual TTY where it allows users to interact with the system (reference).

TTY is a subsystem in Linux and Unix that makes process management, line editing, and session management possible at the kernel level through TTY drivers.

In terms of programming, you need to dive in deep. But, considering the scope of this article, this could be an easy definition to digest.

If you are curious, you can explore an old resource (TTY Demystified) that tries to clear up TTY in Linux and Unix systems with all the technical details you need.

In fact, whenever you launch a terminal emulator or use any kind of shell in your system, it interacts with virtual TTYs that are known as pseudo-TTYs or PTY.

You can just type in TTY in your terminal emulator to find the associated PTY.

How to Access TTY in Linux?
ubuntu tty
It is easy to access TTY in Linux. In fact, when I did not have a clue what it was, I accidentally accessed it and panicked about what to do (how to get out from it).

You can get the TTY screen by using the following keyboard shortcuts on most distributions:

CTRL + ALT + F1 – Lockscreen
CTRL + ALT + F2 – Desktop Environment
CTRL + ALT + F3 – TTY3
CTRL + ALT + F4 – TTY4
CTRL + ALT + F5 – TT5
CTRL + ALT + F6 – TTY6

You can access up to six TTYs in total. However, the first two shortcuts point to the distribution’s lock screen and the desktop environment.

ubuntu tty4
So, you get a command-line interface with the rest of the shortcuts.

When Would You Use TTY in Linux?
TTY is not just a technical treasure. It is useful even for users like me who aren’t developers.

It should come in handy in case the graphical desktop environment freezes. In some cases, reinstalling the desktop environment from the TTY helps resolve the program.

Or, you can also choose to carry out tasks in TTY like updating the Linux system and similar, where you do not want visual issues to interrupt your process.

Worst-case scenario, you can go to the TTY and reboot the computer if your graphical user interface is unresponsive.

Some users also prefer to perform large file transfers with the help of TTY (I am not one of them).

TTY as a Command in Linux
ubuntu terminal tty command
When you type in TTY in your terminal emulator, it will print the file name of the terminal connected to the standard input, as described by the man page.

In other words, to know the TTY number you are connected to, just type in TTY. And, if there are multiple users connected to the Linux machine remotely, you can use the who command to check what other users are connected to.
