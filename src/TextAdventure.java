import java.util.Scanner;

public class TextAdventure {
    public static void main(String[] args) {
        String location = "cave";

        // Must befriend boss to win.
        boolean bossFriended = false;

        Scanner console = new Scanner(System.in);
        String command = null;

        System.out.println("After a long journey, you've finally reached the domain of Zork, King of Cave Skeletons.");


        while (!location.equals("done") && !location.equalsIgnoreCase("victory")) {

            switch (location){
                case "cave":
                    System.out.println("You are in a cave.");
                    System.out.println("Type \"back\" if you wish to leave cave.");
                    System.out.println("The cave branches into two major tunnels.");
                    System.out.println("Type \"east\" if you wish to head east.");
                    System.out.println("Type \"west\" if you wish to head west.");
                    System.out.print("?: ");

                    do {
                        command = console.nextLine();
                    } while (!command.equalsIgnoreCase("back") && !command.equalsIgnoreCase("east") && !command.equalsIgnoreCase("west"));
                    if (command.equalsIgnoreCase("back")) {
                        location = "exit";
                    } else if (command.equalsIgnoreCase("east")) {
                        location = "labyrinth";
                    } else if (command.equalsIgnoreCase("west")){
                        location = "rock trap room";
                    }
                    break;

                case "exit":
                    System.out.println("You walked back out of the cave. Nervous?");
                    System.out.println("Although it's pretty scenic, there's nothing of note here.");
                    System.out.println("Type \"north\" to go back inside. Or just leave, I guess.");
                    System.out.println("?: ");

                    do {
                        command = console.nextLine();
                    }  while (!command.equalsIgnoreCase("north") && !command.equalsIgnoreCase("leave"));
                    if (command.equalsIgnoreCase("north")) {
                        location = "cave";
                    } else if (command.equalsIgnoreCase("leave")) {
                        System.out.println("Ok, bye.");
                        location = "done";
                    }
                    break;

                case "rock trap room":
                    System.out.println("There is a boulder headed for you and there's no way around it,");
                    System.out.println("Type \"try and hide\" to hide from your impending doom");
                    System.out.println("Type \"escape\" to run out of cave");
                    System.out.println("Type \"take on\" to run directly at scary boulder");
                    System.out.print("?: ");
                    do {
                        command = console.nextLine();
                    }   while (!command.equalsIgnoreCase("try and hide") && !command.equalsIgnoreCase("escape") && !command.equalsIgnoreCase("take on"));
                    if (command.equalsIgnoreCase("try and hide")) {
                        System.out.println("You could not find anywhere to hide in time. You died!");
                        location = "done";
                    } else if (command.equalsIgnoreCase("escape")) {
                        System.out.println("You died!");
                        location = "done";
                    } else if (command.equalsIgnoreCase("take on")) {
                        System.out.println("You survived, somehow.");
                        location = "throne room";
                    }
                    break;

                case "labyrinth":
                    String hallway;
                    System.out.println("You travel east into what appears to be a winding hallway.");
                    System.out.println("After 666 minutes of walking past alcoves filled with bones and dust, you find yourself at a crossroad.");
                    String scripts1[] = {"past the armored statue", "into the darkest tunnel", "stepping over a long dried adventurer"};
                    command = hallwayDescription(scripts1);
                    switch (command) {
                        case "forward":
                            String scripts2[] = {"into the deep", "into the skinniest tunnel", "stepping over a slime puddle"};
                            command = hallwayDescription(scripts2);
                            System.out.println("you find yourself sliding down a tunnel and falling back into the cave you started from");
                            location = "new cave";
                            break;
                        case "left":
                            String scripts3[] = {"further into the dark", "further into claustrophobia", "deeper into insanity"};
                            command = hallwayDescription(scripts3);
                            System.out.println("you find yourself pulled by a tentacle into a whirlpool and regurgitated back into the cave you started from");
                            location = "new cave";
                            break;
                        case "right":
                            String scripts4[] = {"dodging past swinging axes", "climbing a rope up a tight, steep, slope", "through a thick, double door that will take all your weight to open"};
                            command = hallwayDescription(scripts4);
                            System.out.println("you slip and fall blindly into a hole, and collide with the floor in the cave you started from");
                            location = "new cave";
                            break;
                        case "back":
                            location = "new cave";
                            break;
                    }
                    break;

                case "new cave":
                    System.out.println("Well, you're back in the entrance. Whole lot of good that did.");
                    System.out.println("You slump against the northern wall of the cave, defeated.");
                    System.out.println("Just as you feel your remaining spirit leaving your body, the wall gives slightly.");
                    System.out.println("As lame as you think secret walls are, you can't help but feel a bit relieved that you might not die in the very first room of a dungeon.");
                    System.out.println("The wall slides to the side, revealing the bony menace on his throne. Are you going to proceed \"north\"? (You are.)");
                    System.out.println("?: ");
                    do {
                        command = console.nextLine();
                    }   while (!command.equalsIgnoreCase("north"));
                    if (command.equalsIgnoreCase("north")) {
                        location = "throne room";
                    }

                case "throne room":
                    System.out.println("After all you've been through, you have finally found Zork, casually slouched in his throne.");
                    System.out.println("Zork: \"Wha? A visitor? Tell me traveler, what year or is it? Or century, for that matter?\"");
                    System.out.println("Zork: \"Oh, but where are my manners? I am known as Zork, King of Cave Skeletons! Or what's left of them, anyway.\"");
                    System.out.println("Zork: \"I have little to offer in terms of refreshment or loot, but I have many a tale...and I am quite lonely...\"");
                    System.out.println("You do have some time to spare, but are you in need of a friend? A dead one, at that? The option is yours: \"befriend\" or \"slay\"?");
                    System.out.println("?: ");
                    do {
                        command = console.nextLine();
                    } while (!command.equalsIgnoreCase("befriend") && !command.equalsIgnoreCase("slay"));
                    if (command.equalsIgnoreCase("befriend")) {
                        System.out.println("Turns out, Zork (King of the remaining Cave Skeletons) is actually a pretty cool guy once you get to know him.");
                        System.out.println("You've discovered the true goal of adventuring: befriending skeletons!");
                        location = "victory";
                    }
                    if (command.equalsIgnoreCase("slay")) {
                        System.out.println("You take your sword and swing mightily, crushing the non-resistant skeleton into dust.");
                        System.out.println("Do you feel good? Is all the repressed anger finally gone? You killed a guy. A hollow victory, perhaps.");
                        location = "done";
                    }


                case "done":
                    System.out.println("Game over!");
                    break;

                case "victory":
                    System.out.println("You are a true winner. Congrats!");
                    break;
            }
        }


    }
    public static String hallwayDescription(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("There are three passage ways to choose from.");
        System.out.printf("You can go \"forward\" %s%n", args[0]);
        System.out.printf("You can go \"left\" %s%n", args[1]);
        System.out.printf("You can go \"right\", %s%n", args[2]);
        System.out.println("Or you can go \"back\" and work up the courage later.");
        String command;
        do {
            command = console.nextLine();
        } while (!command.equalsIgnoreCase("forward") && !command.equalsIgnoreCase("left") && !command.equalsIgnoreCase("right") && !command.equalsIgnoreCase("back"));
        return command;
    }

}
