def solution(m, musicinfos):
    def replace_sharp(melody):
        return melody.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
    
    
    def convert_time_to_min(time):
        t = list(map(int, time.split(":")))
        return t[0] * 60 + t[1]
        
        
    def calc_running_time(start_time, end_time):
        return convert_time_to_min(end_time) - convert_time_to_min(start_time)
    
    
    result = []
    for mi in musicinfos:
        musicinfo = mi.split(",")
        music_name = musicinfo[2]
        running_time = calc_running_time(musicinfo[0], musicinfo[1])
        music_sheet = replace_sharp(musicinfo[3])
        
        while len(music_sheet) < running_time:
            music_sheet += music_sheet
        
        if music_sheet[:running_time].find(replace_sharp(m)) != -1:
            result.append((music_name, running_time))
    
    if not result:
        return "(None)"
    return sorted(result, key = lambda x: x[1], reverse = True)[0][0]
        